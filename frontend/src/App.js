import logo from './logo.svg';
import React from "react";
import './App.css';
import {Main} from "./component/Main";
import Footer from "./component/Footer";
import Header from "./component/Header";
import Sections from "./component/Sections";



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
        return (<div>
            <Header/>
            <Sections/>
            <Main/>
            {/*<BookSection all={true}/>*/}
            {/*<span>{books}</span>// вызывать BookSection all="true/false"*/}
            <Footer/>
        </div>
    );
}

export default App;