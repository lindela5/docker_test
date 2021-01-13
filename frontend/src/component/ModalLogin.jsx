import React from "react";
import {LoginForm} from "./LoginForm";
import {Modal} from "react-bootstrap";


const ModalLogin = () => {

    const [isOpen, setIsOpen] = React.useState(false);
    const [timer, setTimer] = React.useState(0);
    const [startTime, setStartTime] = React.useState(0);
    const [endTime, setEndTime] = React.useState(0);

    const showModal = () => {
        setIsOpen(true);
        // setTitle("Modal Ready");
        document.body.style.backgroundColor = "white";
    };

    const hideModal = () => {
        setIsOpen(false);
    };

    const startTimer = () => {
        setStartTime(Date.now());
    };

    const modalLoaded = () => {
        setEndTime(Date.now());
    };

    const onExit = () => {
        // setTitle("Goodbye 😀");
    };

    const onExited = () => {
        document.body.style.backgroundColor = "green";
        // <Books />
    };


    return <div>
        <button onClick={showModal}>Display Modal</button>
        <Modal
            show={isOpen}
            onHide={hideModal}
            onEnter={startTimer}
            onEntered={modalLoaded}
            onExit={onExit}
            onExited={onExited}
        >
            {/*<Modal show={true} dialogClassName={"primaryModal"}>*/}
            <Modal.Header>
                <Modal.Title>Hi</Modal.Title>
            </Modal.Header>
            <Modal.Body><LoginForm/></Modal.Body>
            <Modal.Footer>This is the footer</Modal.Footer>
        </Modal>
    </div>
};

export default ModalLogin;