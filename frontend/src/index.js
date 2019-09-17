import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';

class Game extends React.Component {
    render() {
        return (<div className="square">heello</div>);
    }
}

ReactDOM.render(<Game />, document.getElementById("root"));