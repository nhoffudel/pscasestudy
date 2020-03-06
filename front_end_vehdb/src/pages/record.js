import React from 'react';
import ReactDOM from 'react-dom';
import RecordPageMenu from 'components/RecordPageMenu';
import DisplayRecords from 'components/DisplayRecords';
import HeaderMenu from 'components/HeaderMenu';

ReactDOM.render(<RecordPageMenu />, document.getElementById('RecordPageMenu'));
ReactDOM.render(<DisplayRecords />, document.getElementById('DisplayRecords'));
ReactDOM.render(<HeaderMenu />, document.getElementById('HeaderMenu'));