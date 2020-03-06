import React from 'react';
import ReactDOM from 'react-dom';
import HeaderMenu from 'components/HeaderMenu';
import TripPageMenu from 'components/TripPageMenu';
import DisplayTrips from 'components/DisplayTrips';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<TripPageMenu />, document.getElementById('TripPageMenu'));
ReactDOM.render(<DisplayTrips />, document.getElementById('DisplayTrips'));