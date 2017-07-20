import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import { Router, Route, hashHistory } from 'react-router'
import Main from './components/main';
import configStore from './store/configStore';
import './css/main.scss';

const store = configStore();

render((
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path="/" component={Main}/>
    </Router>
  </Provider>
), document.getElementById('app'))