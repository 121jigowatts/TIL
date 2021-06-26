import PropTypes from "prop-types";

const User = (props) => {
  return (
    <div>
      <h2>
        Hi! I am {props.name}, and {props.age} years old.
      </h2>
    </div>
  );
};

User.defaultProps = {
  name: "NoName",
  age: 0,
};
User.propTypes = {
  name: PropTypes.string,
  age: PropTypes.number,
};

export default User;
