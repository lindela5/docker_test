import React, { useState } from 'react';

import Box from '@material-ui/core/Box';
import makeStyles from '@material-ui/core/styles/makeStyles';
import useTheme from '@material-ui/core/styles/useTheme';


import {Button, Card} from "react-bootstrap";




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
        <Box >
            <form
                onSubmit={e => handleSubmit(e)}
            >
                <Box >
                    <input
                        label="Login"
                        value={loginData}
                        error={loginError}
                        onChange={e => {
                            setLoginData(e.target.value);
                            setLoginError(false);
                        }}
                    />
                </Box>
                <Box >
                    <input
                        variant="outlined"
                        value={passwordData}
                        error={passwordError}
                        onChange={e => {
                            setPasswordData(e.target.value);
                            setPasswordError(false);
                        }}
                    />
                </Box>
                <Box>
                    <Button variant="primary" className="button">Войти</Button>
                </Box>
            </form>
        </Box>
    )
}

export default LoginForm;