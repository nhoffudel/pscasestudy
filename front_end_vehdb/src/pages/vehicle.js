import React from 'react';
import ReactDOM from 'react-dom';
import VehiclePageMenu from 'components/VehiclePageMenu';
import DisplayVehicles from 'components/DisplayVehicles';
import HeaderMenu from 'components/HeaderMenu';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<VehiclePageMenu />, document.getElementById('VehiclePageMenu'));
ReactDOM.render(<DisplayVehicles />, document.getElementById('DisplayVehicles'));