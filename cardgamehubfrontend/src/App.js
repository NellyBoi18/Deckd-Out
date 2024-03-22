import AddTestUser from "./component/AddTestUser";
import Appbar from "./component/Appbar";
import DisplayTestUser from "./component/DisplayTestUser";
import Footer from "./component/Footer";

function App() {
  return (
    <div className="app">
      <Appbar/>
      <AddTestUser/>
      <DisplayTestUser/>
      <Footer/>
    </div>
  );
}

export default App;
