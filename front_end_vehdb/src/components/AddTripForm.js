import React, { Component } from 'react';
import axios from 'axios';
import style from './Menu.css';

const AddTripForm = (props) => {
  const createTrip = (event) => {
    event.preventDefault();
    axios.post("http://localhost:8080/trip-controller/create", {
        tripID: 1,
        vehicleName: event.target.vehicleName.value,
        dateBegin: event.target.dateBegin.value,
        dateEnd: event.target.dateEnd.value,
        placeBegin: event.target.placeBegin.value,
        placeEnd: event.target.placeEnd.value,
        milesBegin: event.target.milesBegin.value,
        milesEnd: event.target.milesEnd.value,
        cost: event.target.cost.value,
        fuelEcon: event.target.fuelEcon.value,
        owner: 1,
        notes: event.target.notes.value
    }).then( props.history.push("/") )
}
      return (
        <div>
          <form onSubmit={createTrip}>
            <div className="form-group">
              <label htmlFor="vehicleName">Vehicle Name</label><br/>
              <input className="form-control" type="text" required name="vehicleName"></input>
            </div>
            <div className="form-group">
              <label htmlFor="dateBegin">Begin date in MMDDYY</label><br/>
              <input className="form-control" type="number" required name="dateBegin"></input>
            </div>
            <div className="form-group">
              <label htmlFor="dateEnd">End date in MMDDYY</label><br/>
              <input className="form-control" type="number" required name="dateEnd"></input>
            </div>
            <div className="form-group">
              <label htmlFor="placeBegin">Beginning location</label><br/>
              <input className="form-control" type="text" required name="placeBegin"></input>
            </div>
            <div className="form-group">
              <label htmlFor="placeEnd">Ending location</label><br/>
              <input className="form-control" type="text" required name="placeEnd"></input>
            </div>
            <div className="form-group">
              <label htmlFor="milesBegin">Beginning miles</label><br/>
              <input className="form-control" type="number" required name="milesBegin"></input>
            </div>
            <div className="form-group">
              <label htmlFor="milesEnd">Ending miles</label><br/>
              <input className="form-control" type="number" required name="milesEnd"></input>
            </div>
            <div className="form-group">
              <label htmlFor="cost">Cost</label><br/>
              <input className="form-control" type="number" required name="cost"></input>
            </div>
            <div className="form-group">
              <label htmlFor="fuelEcon">Fuel economy</label><br/>
              <input className="form-control" type="number" required name="fuelEcon"></input>
            </div>
            <div className="form-group">
              <label htmlFor="notes">Notes</label><br/>
              <input className="form-control" type="text" required name="notes"></input>
            </div><br/>
            <button type="submit" className={style.MenuButton2}>Add trip</button>
          </form>
        </div>
      );
}
export default AddTripForm;