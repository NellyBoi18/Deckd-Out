// Component representing a flipped custom card
const CustomCardFlipped = ({ card, onClick }) => {
    // Render the flipped custom card
    return (
        <div style={{
            // Styling for the flipped card
            height: "70px",
            width: "50px",
            margin: "10px",
            backgroundColor: "#CC4124", 
            border: "1px solid #000",
            borderRadius: "10px",
            boxShadow: "0 2px 10px rgba(0,0,0,0.3)"
        }} onClick={() => onClick(card)}>
        </div>
    );
};

export default CustomCardFlipped;