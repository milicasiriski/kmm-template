import SwiftUI

struct ButtonWithProgressIndicator: View {
	let label: String
		let loading: Bool
		let action: () -> Void
		
		var body: some View {
			Button(action: action) {
				if loading {
					ProgressView()
						.frame(
							minWidth: 0,
							maxWidth: .infinity,
							minHeight: 55,
							maxHeight: 55,
							alignment: .center
						)
						.background(Color.primary)
						.cornerRadius(8)
				} else {
					Text(NSLocalizedString(label, comment: ""))
						.fontWeight(.bold)
						.foregroundColor(.white)
						.padding()
						.frame(
							minWidth: 0,
							maxWidth: .infinity,
							minHeight: 55,
							maxHeight: 55,
							alignment: .center
						)
						.background(Color.primary)
						.cornerRadius(8)
				}
			}
		}
}

#Preview {
	ButtonWithProgressIndicator(label: "Click me", loading: false, action: {})
}
