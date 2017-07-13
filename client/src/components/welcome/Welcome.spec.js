/* eslint-env jest */
import React from 'react';
import { shallow } from 'enzyme';
import Welcome from './Welcome.jsx';

describe('Welcome component', () => {
  it('Welcome renders Hello World', () => {
    const welcome = shallow(<Welcome />);
    expect(welcome.find('div').text()).toBe('Hello World');
  });
});