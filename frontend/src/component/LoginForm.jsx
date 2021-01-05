import React, { useState } from 'react';

import Box from '@material-ui/core/Box';
import makeStyles from '@material-ui/core/styles/makeStyles';
import useTheme from '@material-ui/core/styles/useTheme';


import {Button, Form} from "react-bootstrap";




export const LoginForm = () => {
    // const theme = useTheme();
    // const classes = useStyles(theme);

    const [loginData, setLoginData] = useState('');
    const [passwordData, setPasswordData] = useState('');

    const [loginError, setLoginError] = useState(false);
    const [passwordError, setPasswordError] = useState(false);

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
        e.preventDefault();
        if (validate()) {
            console.log((loginData, passwordData));
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

        <Form  onSubmit={e => handleSubmit(e)}>
            <Form.Group controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control type="textfield" placeholder="Enter login" />
                <Form.Text className="text-muted">
                    We'll never share your email with anyone else.
                </Form.Text>
            </Form.Group>

            <Form.Group controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" placeholder="Password" />
            </Form.Group>
            <Form.Group controlId="formBasicCheckbox">
                <Form.Check type="checkbox" label="Check me out" />
            </Form.Group>
            <Button variant="primary" type="submit">
                Submit
            </Button>
        </Form>
    )
}

export default LoginForm;