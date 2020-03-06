import React from 'react';
import ReactDOM from 'react-dom';
import HeaderMenu from 'components/HeaderMenu';
import RemoveTripForm from 'components/RemoveTripForm';

ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));
ReactDOM.render(<RemoveTripForm />, document.getElementById('RemoveTripForm'));