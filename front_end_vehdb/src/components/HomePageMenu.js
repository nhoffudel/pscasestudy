import React, { Component } from 'react';
import {Link, BrowserRouter} from 'react-router-dom';
import style from './Menu.css';

export default class HomePageMenu extends Component {
  render() {
    return (
      <BrowserRouter>
      <form action="/vehicle.html">
         <button type="submit" className={style.MenuButton2}>Go to Vehicles</button>
      </form>
      <p></p>
      <form action="/trip.html">
         <button type="submit" className={style.MenuButton3}>Go to Trips</button>
      </form>
      <p></p>
      <form action="/record.html">
         <button type="submit" className={style.MenuButton1}>Go to Service Records</button>
      </form>
      </BrowserRouter>
    );
  }
}
