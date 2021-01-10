import React from 'react';
import { Link } from 'react-router-dom';

function SveikinimoCardComponent({greeting}) {
    return (
        <div className="card mx-auto mb-5" style={{ width: '18rem' }}>
            <div className="card-body text-center">
                <h5 className="card-title">Name: {greeting.name}</h5>
                <p className="card-text">Text: {greeting.text}</p>
                <p className="card-text"><b>Date: {greeting.date}</b></p>
                <p className="card-text">Type: {greeting.type}</p>
                <Link 
                to={`/greetings/${greeting.id}`} 
                className="btn btn-primary"
                >
                   More info
                </Link>
            </div>
        </div>
    );
}

export default SveikinimoCardComponent;