import React from "react";
import { connect } from "react-redux";

import { increment, decrement } from "../actions";

class Counter extends React.Component {
  render() {
    const props = this.props;
    return (
      <React.Fragment>
        <div>count: {props.count}</div>
        <button onClick={props.increment}>+1</button>
        <button onClick={props.decrement}>-1</button>
      </React.Fragment>
    );
  }
}

const mapStateToProps = (state) => ({ count: state.count.value });
const mapDispachToProps = (dispach) => ({
  increment: () => dispach(increment()),
  decrement: () => dispach(decrement()),
});

export default connect(mapStateToProps, mapDispachToProps)(Counter);
