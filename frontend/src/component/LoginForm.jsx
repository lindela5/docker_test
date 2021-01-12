import React, {useState} from 'react';
import {Button, Form} from "react-bootstrap";
import axios from "axios";
import ReactModalLogin from 'react-modal-login';

// import {facebookConfig, googleConfig} from "social-config";


export const LoginForm = () => {
    // const theme = useTheme();
    // const classes = useStyles(theme);

    const [loginData, setLoginData] = useState('');
    const [passwordData, setPasswordData] = useState('');

    const [/*loginError,*/ setLoginError] = useState(false);
    const [/*passwordError, */setPasswordError] = useState(false);

    const validate = () => {
        let valid = true;
        if (loginData.trim().length < 1) {
            setLoginError(true);
            valid = false;
        }
        if (passwordData.trim().length < 1) {
            setPasswordError(true);
            valid = false;
        }
        return valid;
    }

    const handleSubmit = e => {
        console.log(e);
        e.preventDefault();
        if (validate()) {
            console.log(loginData + ' ' + passwordData);
            const config = {
                headers: {'Accept': 'application/json'}
            };
            axios.post("/auth/login", {login: loginData, password: passwordData}, config)
                .then(res => {
                    //this.setState({user: res.data});
                    localStorage.setItem('user', res.data)
                })
                .catch(error => console.log(error));
        }
    }

    return (
        // <Box >
        //     <form
        //         onSubmit={e => handleSubmit(e)}
        //     >
        //         <Box >
        //             <input
        //                 label="Login"
        //                 value={loginData}
        //                 error={loginError}
        //                 onChange={e => {
        //                     setLoginData(e.target.value);
        //                     setLoginError(false);
        //                 }}
        //             />
        //         </Box>
        //         <Box >
        //             <input
        //                 variant="outlined"
        //                 value={passwordData}
        //                 error={passwordError}
        //                 onChange={e => {
        //                     setPasswordData(e.target.value);
        //                     setPasswordError(false);
        //                 }}
        //             />
        //         </Box>
        //         <Box>
        //             <Button variant="primary" type="submit">Войти</Button>
        //         </Box>
        //     </form>
        // </Box>

        <Form onSubmit={e => handleSubmit(e)}>
            <Form.Group controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control type="textfield"
                              placeholder="Enter login"
                              value={loginData}
                              onChange={(e) => setLoginData(e.target.value)}/>
                <Form.Text className="text-muted">
                    We'll never share your email with anyone else.
                </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password"
                              placeholder="Password"
                              value={passwordData}
                              onChange={(e) => setPasswordData(e.target.value)}/>
            </Form.Group>
            {/*<Form.Group controlId="formBasicCheckbox">*/}
            {/*    <Form.Check type="checkbox" label="Check me out"/>*/}
            {/*</Form.Group>*/}
            <Button variant="primary" type="submit">
                Login
            </Button>
        </Form>
    )
}