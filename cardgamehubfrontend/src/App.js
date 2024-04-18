/**
 * This component represents the main application.
 */
// import AddTestUser from "./component/AddTestUser";
// import Appbar from "./component/Appbar";
// import DisplayTestUser from "./component/DisplayTestUser";
// import Footer from "./component/Footer";
import UserComponent from "./component/UserComponent";
import CGRouter from "./component/nav/CGRouter";

/**
 * The main function for the application.
 * @returns {JSX.Element} The JSX element representing the application.
 */
function App() {
  return (
    <div className="app">
      {/* <Appbar/>
      <AddTestUser/>
      <DisplayTestUser/>
      <Footer/> */}
      {/* <CGRouter/> */}
      <UserComponent/>
    </div>
  );
}

export default App;
