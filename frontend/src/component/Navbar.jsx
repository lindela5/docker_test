import React from 'react';
// import {NavLink} from "react-router-dom";
import {Nav} from "react-bootstrap";

const Navbar = () => {
	return <Nav defaultActiveKey="/home" as="ul">
		<Nav.Item as="li">
			<Nav.Link href="/"><li>Home</li></Nav.Link>
		</Nav.Item>
		<Nav.Item as="li">
			<Nav.Link href="/books"><li>Books</li></Nav.Link>
		</Nav.Item>
	</Nav>
};


export default Navbar;


