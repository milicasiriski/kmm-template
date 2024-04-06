import SwiftUI
import shared

struct ItemView: View {
	let item: Item
	
    var body: some View {
		HStack {
			Text("Item \(item.id)")
				.foregroundStyle(.white)
				.padding()
			
			Spacer()
			
			Image(systemName: "chevron.right")
				.foregroundStyle(.white)
				.padding()
		}
		.background(Color.accentColor)
		.clipShape(RoundedRectangle(cornerRadius: 10))
    }
}

#Preview {
    ItemView(item: Item(id: "123", description: "This is a preview item", param: 123, optionalParam: nil))
}
