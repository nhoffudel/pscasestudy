import React, { Component } from 'react';
import {Link, BrowserRouter} from 'react-router-dom';
import style from './Menu.css';

export default class HomePageMenu extends Component {
  render() {
    return (
      <div>
      {/* <img src="img/HomeBanner.gif" className={style.homebanner}></img> */}
      <BrowserRouter>
        <a href="/index.html">Home</a> | <a href="/vehicle.html">Vehicles</a> | <a href="/trip.html">Trips</a> | <a href="/record.html"> Service Records</a>
      </BrowserRouter>
      </div>
    );
  }
}
