import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import axios from 'axios';

class Something extends React.Component {

    state = {
        cards: []
    }

    componentDidMount() {
        axios.get('http://192.168.0.18:9090/debitCards')
        .then(response => this.setState({cards: response.data}))
        .catch(error => {console.log(error)})
    }

    render() {
        const {cards} = this.state
        return (<div className = "square">
                    List of card
                    {
                        cards.length ?
                        cards.map(card => <div key={card.id}> {card.name}</div>) :
                        null
                    }
                </div>
               );
    }
}

ReactDOM.render(<Something />, document.getElementById("root"));