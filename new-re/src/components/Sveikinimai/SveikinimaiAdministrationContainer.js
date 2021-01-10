import React, { Component } from 'react';
import SveikinimaiAdministrationComponent from './SveikinimaiAdministrationComponent';
import axios from 'axios';
import { Link } from 'react-router-dom';
import myUrl from '../../AppConfig';

export default class SveikinimaiAdministrationContainer extends Component {
    constructor() {
        super();
        this.state = {
             greetings: [] 
            };
    }

    componentDidMount() {
        axios.get(`${myUrl}/api/greetings`)
            .then((response) => {
                this.setState({ greetings: response.data });
                //console.log(this.state);
            })
            .catch((error) => {
                console.log(error);
            })
    }


    render() {
        return (
            <main className="container pt-3">
                <div className="row pb-3">
                    <Link 
                    to={`/admin/new`} 
                    className="btn btn-primary"
                    >
                       Add new item
                    </Link>
                </div>
                <div className="row">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Image</th>
                                <th scope="col">Name</th>
                                <th scope="col"></th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.greetings.map((greeting) => {
                                    return (
                                    <SveikinimaiAdministrationComponent 
                                        greeting = {greeting}
                                    />
                                    )
                                })
                            }
                        </tbody>
                    </table>
                </div>
            </main>
        );
    }
}