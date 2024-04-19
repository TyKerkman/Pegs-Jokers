import React, { useState, useEffect } from "react";
import { auth, database, upload } from "../firebase";
import { ref, get, child } from "firebase/database";


const UserProfile = () => {
  const [userData, setUserData] = useState(null);
  const [photo, setPhoto] = useState(null);
  const [loading, setLoading] = useState(false);
  const [photoURL, setPhotoUrl] = useState("https://st3.depositphotos.com/6672868/13701/v/450/depositphotos_137014128-stock-illustration-user-profile-icon.jpg")

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const user = auth.currentUser;
        if (user) {
          const userRef = ref(database, `users/${user.uid}`);
          const snapshot = await get(child(userRef, "/"));
          if (snapshot.exists()) {
            setUserData(snapshot.val());
            if (user?.photoURL) {
              setPhotoUrl(user.photoURL)
            }
          } else {
            console.log("No user data available");
          }
        } else {
          console.log("No user is signed in");
        }
      } catch (error) {
        console.error("Error fetching user data:", error);
      }
    };

    fetchUserData();
  }, []);

  function handleImage(e) {
    if(e.target.files[0]) {
      setPhoto(e.target.files[0])
      console.log("image");
    }
  }

  function handleUpload() {
    console.log("upload");
    upload(photo, auth.currentUser, setLoading)
  }


  return (
    <div className="user-profile">
      {userData ? (
        <div>
          <h2>User Profile</h2>
          <div className="image-field">
            <input type="file" onChange={handleImage} />
            <button disabled={loading} onClick={handleUpload}>Upload</button>
            <img src={photoURL} alt="Profile Picture" className="profile-pic" />
          </div>
          <p>Email: {userData.email}</p>
          <p>Display Name: {userData.name}</p>
          <p>Last Login: {new Date(userData.last_login).toLocaleString()}</p>
        </div>
      ) : (
        <p>Loading...</p>
      )}
    </div>
  );
};

export default UserProfile;