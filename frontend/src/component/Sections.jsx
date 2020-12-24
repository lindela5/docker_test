import React from 'react'
import {Nav, NavItem, NavLink} from 'reactstrap';
import axios from 'axios'

class Sections extends React.Component {
    state = {
        sections: []
    }

    componentDidMount() {
        const config = {
            headers: {'Accept': 'application/json'},
        };
        axios.get("/section/findAll", config)
            .then(res => this.setState({sections: res.data}))
            .catch(error => console.log(error))
            };

    render = () => {
        console.log(this.state.sections);
        return (<div>
                <p>List Based</p>
                <p>{this.state.sections.nameSection}</p>
                <Nav vertical>
                    <NavItem>
                        <NavLink href="#">{this.state.sections.nameSection}</NavLink>
                    </NavItem>
                </Nav>
            </div>

        )
    }
}

export default Sections;