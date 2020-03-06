import React, { Component } from 'react';
import style from './Menu.css';

export default class DisplayRecords extends Component {
  constructor(props){
    super(props);
    this.state = {
        error : null,
        isLoaded : false,
        records : []        
    };
}

componentDidMount() {
  fetch("http://localhost:8080/record-controller/read-all")
  .then( response => response.json())
  .then(
      (result) => {
          this.setState({
              isLoaded : true,
              records : result
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
            records.map(record => (
              <li key={record.ID} align="start">
              <div>
              <p>VIn: {record.vehicleVIN}</p>
              <p>Service name: {record.name}</p>
              <p>Date: {record.date} at {record.location} at {record.miles} miles</p>
              <p>Cost: {record.cost}</p>
              <p>Notes: {record.notes}</p>
              </div>
              </li>
              ))
          }
          </ol>
        </div>
      );
    }    
}
