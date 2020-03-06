import React from 'react';
import ReactDOM from 'react-dom';
import HeaderMenu from 'components/HeaderMenu';
import AddVehicleForm from 'components/AddVehicleForm';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<AddVehicleForm />, document.getElementById('AddVehicleForm'));