import React from 'react'
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from './pages/Home'
import Profile from './pages/Profile';
import Game from './pages/Game';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Landing from './pages/Landing';
import Reset from './pages/Reset';

function App() {
  
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Landing />} />
          <Route path="/home" element={<Home />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/game" element={<Game />} />
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route path="/reset" element={<Reset />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
