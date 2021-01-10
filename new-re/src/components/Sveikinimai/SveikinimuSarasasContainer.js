import React, { Component } from 'react';
import axios from 'axios';
import SveikinimoCardComponent from './SveikinimoCardComponent';
import myUrl from '../../AppConfig';

export default class SveikinimuSarasasContainer extends Component {
    constructor() {
        super();
        this.state = {
            greetings: []
        }
    }

    componentDidMount() {
        document.title = "greetings";
        axios.get('/uzduotis-ap/api/greetings')
            .then(res => {
                this.setState({greetings: res.data})
            })
            .catch(err => {
                console.log(err);
            })
    }

    render() {
        return (
            <main className="container pt-3">
                <div className="row">
                    {
                        this.state.greetings.map(greeting => {
                            return (
                                <SveikinimoCardComponent greeting={greeting} />
                            )
                        })
                    }
                </div>
            </main>
        );
    }

}