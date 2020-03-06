import React, { Component } from 'react';
import {Link, BrowserRouter} from 'react-router-dom';
import style from './Menu.css';

export default class VehiclePageMenu extends Component {
  render() {
    return (
            <BrowserRouter>
            <form action="/addvehicle.html">
               <button type="submit" className={style.MenuButton2}>Add vehicle</button>
            </form>
            <p></p>
            <form action="/editvehicle.html">
               <button type="submit" className={style.MenuButton3}>Edit vehicle</button>
            </form>
            <p></p>
            <form action="/removevehicle.html">
               <button type="submit" className={style.MenuButton1}>Delete Vehicle</button>
            </form>
            </BrowserRouter>
    );
  }
}
