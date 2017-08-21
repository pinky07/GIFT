import React from 'react';
import renderer from 'react-test-renderer';

import NotFound from './NotFound';

describe('NotFound', () => {

    let actual;
    it('should render the correct title and message', () => {
        actual = renderer.create(<NotFound/>).toJSON();

        expect(actual).toMatchSnapshot();
    });
});