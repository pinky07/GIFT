import React from 'react'
import { render } from 'react-dom';
import { Provider } from 'react-redux';
import { Router, Route, hashHistory, IndexRoute } from 'react-router'

import Main from './components/masterPage/main';
import NotFound from './components/masterPage/notFound/NotFound';

import configStore from './components/masterPage/store/configStore';
import './css/main.scss';

import ProjectList from './components/portfolios/projects/ProjectList';
import Portfolios from './components/portfolios/Portfolios';
import DashboardController from './components/projects/dashboard/DashboardController';

const store = configStore();

render((
  <Provider store={store}>
    <Router history={hashHistory}>
      <Route path={"/"} component={Main}>
        <IndexRoute component={Portfolios}></IndexRoute>
        <Route path={"portfolios"} component={Portfolios}></Route>
        <Route path={"projects/:id"} component={ProjectList}></Route>
        <Route path={"projects/:id/dashboard"} component={DashboardController}></Route>
        <Route path="*" component={NotFound} />
      </Route>

    </Router>
  </Provider>
), document.getElementById('app'))