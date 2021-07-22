const Mailbox = (props) => {
  const unreadMessages = props.unreadMessages;
  return (
    <div>
      <h1>Mailbox</h1>
      {unreadMessages.length > 0 && (
        <h2>You have {unreadMessages.length} unread mesages.</h2>
      )}
    </div>
  );
};

export default Mailbox;
