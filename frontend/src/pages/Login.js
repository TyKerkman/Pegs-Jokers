import React, { useState } from "react";
import {
  signInWithEmailAndPassword,
  browserLocalPersistence,
} from "firebase/auth";
import { auth } from "../firebase";

import { NavLink, Link, useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const onLogin = (e) => {
    e.preventDefault();
    signInWithEmailAndPassword(auth, email, password)
      .then((userCredential) => {
        // Signed in
        const user = userCredential.user;
        auth.setPersistence(browserLocalPersistence);
        navigate("/home");
        console.log(user);
      })
      .catch((error) => {
        const errorCode = error.code;
        const errorMessage = error.message;
        console.log(errorCode, errorMessage);
      });
  };

  return (
    <>
      <main>
        <section>
          <div className="login-container">
            <h1 className="title">Login</h1>
            <form className="login-form">
              <div className="form-group">
                <label htmlFor="email-address">Email address</label>
                <input
                  id="email-address"
                  name="email"
                  type="email"
                  required
                  placeholder="Email address"
                  onChange={(e) => setEmail(e.target.value)}
                />
              </div>
              <div className="form-group">
                <label htmlFor="password">Password</label>
                <input
                  id="password"
                  name="password"
                  type="password"
                  required
                  placeholder="Password"
                  onChange={(e) => setPassword(e.target.value)}
                />
              </div>

              <div className="form-group">
                <button className="button-3" onClick={onLogin}>
                  Login
                </button>
              </div>
            </form>

            
            <div className="no-account">
              <p className="no-account-text">No account yet?</p>
              <Link className="button-3" to="/signup">Sign up</Link>
            </div>
          </div>
        </section>
      </main>
    </>
  );
};

export default Login;
