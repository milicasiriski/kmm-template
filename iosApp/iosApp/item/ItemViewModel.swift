import Foundation
import shared

@MainActor
class ItemViewModel: ObservableObject {
	private let item: Item
	
	init(item: Item) {
		self.item = item
	}
}
