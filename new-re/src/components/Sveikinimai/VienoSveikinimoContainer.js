import React, { Component } from 'react';
import axios from 'axios';
import VienoSveikinimoComponent from './VienoSveikinimoComponent';
import myUrl from '../../AppConfig';


export default class VienoSveikinimoContainer extends Component {
    constructor() {
        super();
        this.state = {
            greeting: {}
        }
    }

    componentDidMount() {
        axios.get(`${myUrl}/api/greetings/${this.props.match.params.id}`)
            .then(res => {
                this.setState({ greeting: res.data });
                console.log(res.data);
            })
            .catch(err => {
                console.log(err);
            })
    }

    render() {
        return (
            <main className="container pt-3">
                <div className="row">
                    <VienoSveikinimoComponent greeting={this.state.greeting} />
                </div>
            </main>
        );
    }
}