import { createStore, applyMiddleware } from 'redux';
import ReduxThunk from 'redux-thunk';
import reducers from './reducers';

export default function configStore() {
  return createStore(reducers,{projects: []}, applyMiddleware(ReduxThunk));
}