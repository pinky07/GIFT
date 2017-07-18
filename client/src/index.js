import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import configStore from './store/configStore';
import ProjectList from './components/projects/ProjectList';

const store = configStore();

ReactDOM.render(
  <Provider store={store}>
    <ProjectList />
  </Provider>,
  document.getElementById('app')
);
