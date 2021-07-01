import { div } from "prelude-ls";
import React from "react";

class Clock extends React.Component {
  constructor(props) {
    super(props);
    this.state = { date: new Date() };
  }

  componentDidMount() {
    console.log("Component did mount.");
    this.timerID = setInterval(() => this.tick(), 1000);
  }

  componentWillUnmount() {
    console.log("Component will unmount.");
    clearInterval(this.timerID);
  }

  tick() {
    this.setState({ date: new Date() });
  }

  render() {
    return (
      <div>
        <h2>It is {this.state.date.toLocaleTimeString()}.</h2>
      </div>
    );
  }
}

export default Clock;
