import React from 'react';
// import {NavLink} from "react-router-dom";
import {Nav} from "react-bootstrap";

const Header = () => {
    return <div className="book-header">
        <div className="flex-container flex-end"><p>admin</p></div>
        <div className="fig"><img src="https://i.ibb.co/tzy7qSS/unnamed.png" className="img-fluid"
                                  alt="Responsive image">
        </img>
        </div>
        <Nav defaultActiveKey="/home" as="ul" className="nav-menu">
            <Nav.Item as="li">
                <Nav.Link href="/">
                    <li>Home</li>
                </Nav.Link>
            </Nav.Item>
            <Nav.Item as="li">
                <Nav.Link href="/books">
                    <li>Books</li>
                </Nav.Link>
            </Nav.Item>
        </Nav>
    </div>
};


export default Header;


