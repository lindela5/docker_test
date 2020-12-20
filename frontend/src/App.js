import logo from './logo.svg';
import React from "react";
import './App.css';
import Books from "./component/Books";
import {Route, Router} from "react-router";

function App() {
    // return (
    //   <div className="App">
    //     <header className="App-header">
    //       <img src={logo} className="App-logo" alt="logo" />
    //       <p>
    //         Edit <code>src/App.js</code> and save to reload.
    //       </p>
    //       <a
    //         className="App-link"
    //         href="https://reactjs.org"
    //         target="_blank"
    //         rel="noopener noreferrer"
    //       >
    //         Learn React
    //       </a>
    //     </header>
    //   </div>
    // );
    return (
        <Router>
            <Route exact path="/" component={Books}/>
            <Route exact path="/books" component={Books}/>
        </Router>
    );
}

export default App;
