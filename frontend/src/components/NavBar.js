import React from 'react';

const NavBar = ({ title }) => {
    return (
      <nav className="navBar">
        <button className="navButton" onClick={() => window.location.href = '/'}>
          Home
        </button>
        <h1 className="navTitle">{title}</h1>
      </nav>
    );
  };

export default NavBar;