const FlippedCustomCard = ({ card, onClick }) => {
    return (
        <div style={{
            height: "70px",
            width: "50px",
            backgroundColor: "#CC4124", 
            border: "1px solid #000",
            borderRadius: "10px",
            marginLeft: "-30px",
            position: 'relative'
        }} onClick={() => onClick(card)}>
        </div>
    );
};

export default FlippedCustomCard;
