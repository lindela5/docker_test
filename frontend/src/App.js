import logo from './logo.svg';
import React from "react";
import './App.css';
import Books from "./component/Books.jsx";
import {Route} from "react-router-dom";
import {Main} from "./component/Main";
import BookSection from "./component/BookSection";

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
        // <div><span>sss</span></div>
        <>
            {/*<BrowserRouter>*/}
            {/*<Switch>*/}
            <Route exact path="/" component={Main}/>
            <Route exact path="/books" component={Books}/>
            <Route exact path="/section/:id" component={BookSection}/>
                {/*</Switch>*/}
                {/*</BrowserRouter>*/}
            </>
            );
            }

export default App;
