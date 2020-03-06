import React, { Component } from 'react';
import style from './Menu.css';

export default class DisplayVehicles extends Component {
  constructor(props){
    super(props);
    this.state = {
        error : null,
        isLoaded : false,
        vehicles : []        
    };
}

componentDidMount() {
  fetch("http://localhost:8080/vehicle-controller/read-all")
  .then( response => response.json())
  .then(
      (result) => {
          this.setState({
              isLoaded : true,
              vehicles : result
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
            vehicles.map(vehicle => (
              <li key={vehicle.VIN} align="start">
              <div>
              <p>{vehicle.name}</p>
              <p>{vehicle.year} {vehicle.make} {vehicle.model} {vehicle.trim}</p>
              <p>Engine: {vehicle.engine} Color: {vehicle.color}</p>
              <p>Notes: {vehicle.notes}</p>
              </div>
              </li>
              ))
          }
          </ol>
        </div>
      );
    }    
}
