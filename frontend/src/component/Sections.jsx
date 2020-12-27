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

    // renderSectionBooks(sectionId) {
    //     console.log(sectionId);
    //
    // };


    render = () => {
        console.log(this.state.sections);


        const sections = this.state.sections.map(section =>
            <NavItem key={section.id}>
                <NavLink href={"/section/" + section.id}>{section.nameSection}</NavLink>
            </NavItem>);
        return (<div>
                <Nav vertical className="flex-column">
                    {sections}
                </Nav>
            </div>

        )
    }
}

export default Sections;