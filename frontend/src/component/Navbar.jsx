import React from 'react';
import {NavLink} from "react-router-dom";

const Navbar = () => {
	return <nav className='nav'>
		<ul>
			<NavLink to="/"><li>Home</li></NavLink>
			<NavLink to="/books"><li>Books</li></NavLink>
		</ul>
	</nav>
};

export default Navbar;