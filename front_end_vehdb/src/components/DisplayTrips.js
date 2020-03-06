import React, { Component } from 'react';
import style from './Menu.css';

export default class DisplayTrips extends Component {
  constructor(props){
    super(props);
    this.state = {
        error : null,
        isLoaded : false,
        trips : []        
    };
}

componentDidMount() {
  fetch("http://localhost:8080/trip-controller/read-all")
  .then( response => response.json())
  .then(
      (result) => {
          this.setState({
              isLoaded : true,
              trips : result
          });
      },
      (error) => {
          this.setState({
              isLoaded: true,
              error
          })
      },
  )
}

  render() {
    return(
      <div>
        <ol>
          {
            trips.map(trip => (
              <li key={trip.tripID} align="start">
              <div>
              <p>Vehicle used: {trip.vehicleName}</p>
              <p>Trip began on {trip.dateBegin} at {trip.placeBegin} at {trip.milesBegin} miles</p>
              <p>Trip ended on {trip.dateEnd} at {trip.placeEnd} at {trip.milesEnd} miles</p>
              <p>Cost: {trip.cost} Fuel economy: {trip.fuelEcon}</p>
              <p>Notes: {trip.notes}</p>
              </div>
              </li>
              ))
          }
          </ol>
        </div>
      );
    }    
}
