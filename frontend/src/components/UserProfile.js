import React, { useState, useEffect } from "react";
import { auth, database } from "../firebase";
import { ref, get, child } from "firebase/database";

const UserProfile = () => {
  const [userData, setUserData] = useState(null);

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const user = auth.currentUser;
        if (user) {
          const userRef = ref(database, `users/${user.uid}`);
          const snapshot = await get(child(userRef, "/"));
          if (snapshot.exists()) {
            setUserData(snapshot.val());
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

  return (
    <div className="user-profile">
      {userData ? (
        <div>
          <h2>User Profile</h2>
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