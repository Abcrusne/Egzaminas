import React from 'react';
import { NavLink } from 'react-router-dom';

const NavBar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <ul className="nav navbar-nav mr-auto">
          <li className="nav-item active">
            <NavLink className="nav-link" exact to="/">
              Home
            </NavLink>
          </li>
          <li className="nav-item active">
            <NavLink className="nav-link" to={`/admin/greetings`}>
              Admin
            </NavLink>
          </li>
          <li className="nav-item active">
            <NavLink className="nav-link" to={`/places`}>
              Places
            </NavLink>
          </li>
        </ul>
        {/* <ul className="nav navbar-nav navbar-right">
          <li className="nav-item active">
           
          </li>
        </ul> */}
      </div>
    </nav>
  );
};
export default NavBar;
