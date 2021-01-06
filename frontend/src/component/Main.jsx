import React from "react";
import Navbar from "./Header";
import axios from "axios";
// import {Book} from "./Book";
import {LoginForm} from "./LoginForm";
import BookSection from "./BookSection";
import {
    BrowserRouter as Router,
    Link,
    Route,
    Redirect
} from 'react-router-dom'
import Books from "./Books";
import './Book.css';


// axios.get("/auth/login", config)
//     .then(res => this.setState({sections: res.data}))
//     .catch(error => console.log(error));


const fakeAuth = {
    isAuthenticated: false,
    authenticate(cb) {
        this.isAuthenticated = true
        setTimeout(cb, 100) // fake async
    },
    signout(cb) {
        this.isAuthenticated = false
        setTimeout(cb, 100) // fake async
    }
}

const PrivateRoute = ({ component: Component, ...rest }) => (
    <Route {...rest} render={(props) => (
        fakeAuth.isAuthenticated === true
            ? <Component {...props} />
            : <Redirect to='/login' />
    )} />
)

export class Main extends React.Component {



    render = () => {

        return (
// <div><span>sss</span></div>
            <>
                {/*<BrowserRouter>*/}
                {/*<Switch>*/}
                <Route exact path="/" render={() => <BookSection all={true}/>}/>
                {/*<Route exact path="/books" component={Books}/>*/}
                <Route exact path="/section/:id" component={BookSection}/>
                <Route path="/login" component={LoginForm} />
                <PrivateRoute path='/books' component={Books} />
                {/*</Switch>*/}
                {/*</BrowserRouter>*/}
            </>
        );
    };



};