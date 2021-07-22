import Counter from "./Counter";
import User from "./User";
import Product from "./Product";
import Clock from "./Clock";
import Toggle from "./Toggle";
import LoginControl from "./LoginControl";
import Mailbox from "./Mailbox";

function App() {
  const profiles = [{ name: "Alice", age: 16 }, { name: "Bob", age: 31 }, {}];
  const messages = ["React", "Re: React", "Re:Re: React"];
  return (
    <div>
      <h1>Hello, World!</h1>
      <Clock />
      <button
        onClick={() => {
          console.log("push!");
        }}
      >
        PUSH!
      </button>
      {profiles.map((profile, index) => {
        return <User name={profile.name} age={profile.age} key={index} />;
      })}
      <Counter />
      <Product />
      <Toggle />
      <LoginControl />
      <Mailbox unreadMessages={messages} />
    </div>
  );
}

export default App;
